# package_verifier
Package Verifier

Step 1. Add the JitPack repository to your build file

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  ----------------------------------------------------
  Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.santacoderofficial:package_verifier:Tag'
	}
