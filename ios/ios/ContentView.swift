import SwiftUI

func greet() -> String {
    return "greet"
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
