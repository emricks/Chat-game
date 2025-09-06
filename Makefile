build:
	mkdir bin
	javac -d bin -sourcepath src src/Main.java

run: clean build
	java -cp bin Main

clean:
	rm -rf bin