package sand;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SandRun extends SpringBootServletInitializer {
	private final static Logger logger = Logger.getLogger(SandRun.class);



	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SandRun.class);
	}

	 public static void main(String[] args) {

		 SpringApplication.run(SandRun.class, args);
		 logger.info("-----------app  run up  finish");
		/* Runtime.getRuntime().addShutdownHook(new Thread(){
			 @Override
			 public void run() {
				 logger.info("Shutting down scloud-pmpf-consumer, unregister from Eureka!");
				 DiscoveryManager.getInstance().shutdownComponent();
			 }
		 });*/

	}

}
