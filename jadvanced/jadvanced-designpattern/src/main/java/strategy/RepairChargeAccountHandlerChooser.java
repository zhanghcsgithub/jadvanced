package strategy;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import test.zhc.dao.strategy.RepairChargeAccountHandler;

@Component
public class RepairChargeAccountHandlerChooser implements ApplicationContextAware {

	@Autowired
	private ApplicationContext context;
	
	private Map<String,RepairChargeAccountHandler> chooseMap = new HashMap<String,RepairChargeAccountHandler>();

	public RepairChargeAccountHandler choose(String type){

		return chooseMap.get(type);

	}

	@PostConstruct
	public void register () {

		Map<String,RepairChargeAccountHandler> solverMap = context.getBeansOfType(RepairChargeAccountHandler.class);

		for (RepairChargeAccountHandler solver : solverMap.values()) {
		}
	}

	

	public void setApplicationContext (ApplicationContext applicationContext) throws BeansException {
		this .context=applicationContext;
	}


	

}

