import SwiftUI
import MultiPlatformLibrary
import MultiPlatformLibraryMvvm

func greet() -> String {
    let says = Greeting(hello: "Hello", world: "World")
    return "\(says.hello) \(says.world)!"
}

struct ContentView: View {
    var body: some View {
        Text(greet())
            .font(.body)
            .foregroundColor(.red)
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
