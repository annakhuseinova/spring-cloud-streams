package com.annakhuseinova.springcloudstreams;

import com.annakhuseinova.springcloudstreams.kafka.json.service.InvoiceProducerService;
import com.annakhuseinova.springcloudstreams.kafka.json.service.datagenerator.InvoiceGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ApplicationRunner interface is used to override the main method to add some custom logic
 * */
@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class SpringCloudStreamsApplication implements ApplicationRunner {

    private final InvoiceProducerService producerService;
    private final InvoiceGenerator invoiceGenerator;
    @Value("${application.configs.invoice.count}")
    private int INVOICE_COUNT;

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamsApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i=0; i < INVOICE_COUNT; i++){
            producerService.sendMessage(invoiceGenerator.getRandomInvoice());
            Thread.sleep(1000);
        }
    }
}
