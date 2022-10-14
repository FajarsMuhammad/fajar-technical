package com.fajar;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.*;
import org.springframework.shell.boot.*;
import org.springframework.shell.jline.PromptProvider;

import java.io.IOException;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {
//    SpringShellAutoConfiguration.class,
//    JLineShellAutoConfiguration.class,
//    StandardAPIAutoConfiguration.class,
//    StandardCommandsAutoConfiguration.class,
//    LineReaderAutoConfiguration.class,
//    ShellRunnerAutoConfiguration.class,
//    CompleterAutoConfiguration.class,
//    ParameterResolverAutoConfiguration.class
//})
public class FajarCliApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication application = new SpringApplication(FajarCliApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }

    @Bean
    public PromptProvider myPromptProvider() {
        return () -> new AttributedString("fajars:>",
            AttributedStyle.DEFAULT.foreground(AttributedStyle.GREEN));
    }

}
