

run-dist:
	./build/install/app/bin/app src/test/resources/file1.json src/test/resources/file2.json

run-dist2:
	./build/install/app/bin/app src/test/resources/file1.yml src/test/resources/file2.yml

help:
	@./build/install/app/bin/app -h

clean:
	@./gradlew clean

install:
	@./gradlew clean install

lint:
	@./gradlew checkstyleMain checkstyleTest

test:
	@./gradlew test


build:
	@./gradlew clean build

report:
	@./gradlew jacocoTestReport

.PHONY: build