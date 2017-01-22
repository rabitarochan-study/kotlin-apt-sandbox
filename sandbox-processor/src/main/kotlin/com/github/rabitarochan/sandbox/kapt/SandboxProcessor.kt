package com.github.rabitarochan.sandbox.kapt

import java.io.PrintWriter
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.RoundEnvironment
import javax.annotation.processing.SupportedAnnotationTypes
import javax.annotation.processing.SupportedSourceVersion
import javax.lang.model.SourceVersion
import javax.lang.model.element.Element
import javax.lang.model.element.TypeElement
import javax.tools.Diagnostic
import javax.tools.StandardLocation

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("com.github.rabitarochan.sandbox.kapt.TestAnnotation")
class SandboxProcessor : AbstractProcessor() {

    private var round: Int = 1

    override fun process(annotations: MutableSet<out TypeElement>, roundEnv: RoundEnvironment): Boolean {
        if (annotations.isEmpty()) { return true }

        val messager = processingEnv.messager
        val filer = processingEnv.filer

        val elements = roundEnv.getElementsAnnotatedWith(annotations.first())
        for (element in elements) {
            val targetName = element.toString()
            println("target : $targetName")
            val clazz = Class.forName(targetName)
            println("clazz : $clazz")
        }

        val fileObject = filer.createResource(StandardLocation.CLASS_OUTPUT, "", "result.txt", null)
        PrintWriter(fileObject.openWriter(), true).use { writer ->
            writer.println("Test!!")
        }

        return true
    }

}
