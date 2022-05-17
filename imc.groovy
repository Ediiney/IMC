import com.sap.gateway.ip.core.customdev.util.Message;
import java.text.DecimalFormat; 
import groovy.json.*;
    
    def Message processData(Message message) {

        def body = message.getBody(String)
        def jsonParser = new JsonSlurper()
        def jsonObject = jsonParser.parseText(body)
        def imc =  jsonObject.peso / (jsonObject.altura * jsonObject.altura)
        def df = new DecimalFormat("#00.0")
        def formatted = df.format(imc)
        
    
    if ( imc <= 18.0) {
        message.setBody("IMC " + formatted + " Abaixo do peso")
    } else if (imc <= 24.9 && imc >= 18.5) {
        message.setBody("IMC " + formatted + " Normal")

    } else if (imc <= 25.0 && imc >= 29.9){
        message.setBody("IMC " + formatted + " Sobrepeso")

    } else if (imc >= 30.0 && imc <= 39.9){
        message.setBody("IMC " + formatted + " Obsesidade")
    } else if (imc >= 40.0){
        message.setBody("IMC " + formatted + " Grave Obsesidade")
    }
    return message;
    }
 