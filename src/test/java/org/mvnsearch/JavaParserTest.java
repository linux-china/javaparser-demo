package org.mvnsearch;


import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.printer.YamlPrinter;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;

import static com.github.javaparser.StaticJavaParser.parse;

/**
 * Java Parser test
 *
 * @author linux_china
 */
public class JavaParserTest {
    @Test
    public void testParse() {
        String code = "@interface AD { String foo(); }";
        CompilationUnit cu = parse(code);
        TypeDeclaration<?> typeDeclaration = cu.getTypes().get(0);
        if (typeDeclaration instanceof ClassOrInterfaceDeclaration classOrInterfaceDeclaration) {
            System.out.println(classOrInterfaceDeclaration.isInterface());
        }
        System.out.println(typeDeclaration.getName());
    }

    @Test
    public void testGeneration() {
        CompilationUnit cu = new CompilationUnit();
        ClassOrInterfaceDeclaration myClass = cu.addClass("MyClass").setPublic(true);
        myClass.addField(String.class, "name", Modifier.Keyword.PUBLIC);
        System.out.println(myClass.toString());
    }

    @Test
    void testYamlPrinter() throws Exception {
        FileReader fileReader = new FileReader(new File("src/main/java/org/mvnsearch/User.java"));
        YamlPrinter.print(StaticJavaParser.parse(fileReader));
        fileReader.close();
    }
}
