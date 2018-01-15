package utils

import common.BaseTestSpec
import groovy.json.JsonSlurper

class commonutils {

    static def getDataFromJson(String path) {
        def inputFile = new File(path)
        new JsonSlurper().parseText(inputFile.text)
    }

    static String getPathToProducts() {
        def path = (System.getProperty("user.dir")
        +File.separator + "src"
        +File.separator + "main"
        +File.separator + "resources"
        +File.separator + "environments"
        +File.separator + System.getProperty("env")
        +File.separator + "default_products.json")

        return  path
    }

    static String getPathToData() {
        def path = (System.getProperty("user.dir")
        +File.separator + "src"
        +File.separator + "main"
        +File.separator + "resources"
        +File.separator + "environments"
        +File.separator + System.getProperty("env")
        +File.separator + "data.json")

        return  path
    }
}