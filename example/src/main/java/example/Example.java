package example;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import javassist.ClassPool;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Example {
    public static void main(String[] args) {
        // Userクラス使ってみる
        User user = new User("pochi", 5, 80.0f, 80.0f);
        System.out.println(user.getUserInfo());

        // Userクラスをパースする
        Path source = Paths.get("src/main/java/example/User.java");
        try {
            CompilationUnit unit = JavaParser.parse(source);
            System.out.println("***********************************************");
            System.out.println(unit);
            System.out.println("***********************************************");
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
}