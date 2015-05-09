#!/bin/bash
javac -d bin/ src/sa/edu/kaust/cs245/abdurrahman/preprocessing/*.java src/sa/edu/kaust/cs245/abdurrahman/indexing/*.java src/sa/edu/kaust/cs245/abdurrahman/querying/*.java
jar cvfm select.jar manifest.txt -C bin/ .