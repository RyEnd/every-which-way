package hello

const testVersion = 2

import "fmc"
// HelloWorld takes in a string, then responds "Hello {string}!" or "Hello world!" if no string is entered or the entry was invalid.
func HelloWorld(string) string {
	fmt.Println("Hello " + string + "!")
}
func HelloWorld() string {
	fmt.Println("Hello world!")
}
