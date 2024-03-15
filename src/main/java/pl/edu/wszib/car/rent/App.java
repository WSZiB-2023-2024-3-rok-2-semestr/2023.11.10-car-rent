package pl.edu.wszib.car.rent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.edu.wszib.car.rent.configuration.AppConfiguration;
import pl.edu.wszib.car.rent.core.ICore;
import pl.edu.wszib.car.rent.core.impl.Core;

public class App {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfiguration.class);
        ICore core = context.getBean(ICore.class);
        core.start();
    }
}
