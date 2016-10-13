package hello

const testVersion = 2

// HelloWorld takes in a string, then responds "Hello {string}!" or "Hello world!" if no string is entered or the entry was invalid.
func HelloWorld(name string) string {
	if name == "" {
		name = "World"
	}
	return ("Hello, " + name + "!")
}