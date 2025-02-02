package net.mureng.batch;

import net.mureng.BatchBasePackage;
import net.mureng.CoreBasePackage;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication(scanBasePackageClasses = { CoreBasePackage.class, BatchBasePackage.class })
public class MurengBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(MurengBatchApplication.class, args);
	}

}
