package com.ubiblio.view;

import com.ubiblio.service.BukuService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.SwingUtilities;

@Component
public class SwingRunner implements CommandLineRunner {

    private final BukuService service;
    private final ConfigurableApplicationContext context;

    public SwingRunner(
        BukuService service,
        ConfigurableApplicationContext context
    ) {
        this.service = service;
        this.context = context;
    }

    @Override
    public void run(String... args) {

        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame(service, context);
            frame.setVisible(true);
        });
    }
}

