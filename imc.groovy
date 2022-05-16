import com.sap.gateway.ip.core.customdev.util.Message;
import groovy.json.*;
    
    def Message processData(Message message) {

        def body = message.getBody(String)
        def jsonParser = new JsonSlurper()
        def jsonObject = jsonParser.parseText(body)
        def imc =  jsonObject.peso / (jsonObject.altura * jsonObject.altura)
        println imc
    
    if (imc < 24.9 && imc > 18.5) {
        println imc + " IMC Normal"

    } else if (imc < 25.0 && imc > 29.9){
        println imc + " IMC Sobrepeso"

    } else if (imc >30.0 && imc < 39.9){
        println imc + " IMC Obsesidade"
    } else if (imc >40.0){
        println imc + " IMC Grave Obsesidade"
    }
    return message;
    }
 