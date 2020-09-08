//
//  Resource.swift
//  Dinosaurs
//
//  Created by Egor Andreevici on 2019-12-23.
//  Copyright © 2019 Square. All rights reserved.
//

import Combine
import Foundation
import protos

final class DinosaurResource: ObservableObject {
  let url = URL(string: "https://wire-dinosaurs-demo.herokuapp.com/dinosaur")!
  let didChange = PassthroughSubject<Dinosaur?, Never>()
  var value: Dinosaur? {
    willSet {
      DispatchQueue.main.async {
        self.didChange.send(self.value)
      }
    }
  }
  init() {
    reload()
  }
  func reload() {
    let task = URLSession.shared.dataTask(with: url) { data, response, error in
      if let clientError = error {
        self.handleClientError(error: clientError)
        return
      }
      guard let httpResponse = response as? HTTPURLResponse, (200...299).contains(httpResponse.statusCode) else {
        self.handleServerError(response: response as! HTTPURLResponse)
        return
      }
      self.value = self.toDinosaur(data: data!).freeze()
    }
    task.resume()
  }
  
  func handleClientError(error: Error) {
    print("Client error: \(error.localizedDescription)")
  }
  
  func handleServerError(response: HTTPURLResponse) {
    print("Response: \(response.statusCode)")
  }
  
  func toDinosaur(data: Data) -> Dinosaur {
    return Dinosaur.Companion.init().ADAPTER.decode(data: data) as! Dinosaur
  }
}
