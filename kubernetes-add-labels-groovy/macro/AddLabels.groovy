import com.xebialabs.deployit.plugin.stitch.service.engine.processor.handler.groovy.MapFunction

def stitch(spec, params, document, ctx) {
    document.map('$..labels', new MapFunction() {
        Object map(currentValue) {
            currentValue.put("myGroovyScriptFileLabel", "myGroovyValueFromFile")
            currentValue.put("scriptFileGroovyDeployedId", ctx.deployed.id.replaceAll("/", "-"))
            currentValue
        }
    })
    document.getMutatedDocument()
}
