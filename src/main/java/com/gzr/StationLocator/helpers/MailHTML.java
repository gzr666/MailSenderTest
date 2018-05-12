package com.gzr.StationLocator.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.WebContext;

//klasa koja definira sadrzaj maila u html formatu pomocu thymeleaf-a

@Service
public class MailHTML {

	private TemplateEngine templateEngine;
	
	
	@Autowired
	public MailHTML(TemplateEngine templateEngine)
	{
		this.templateEngine = templateEngine;
		
	}
	
	public String build(String message) {
        Context context = new Context();
       
        context.setVariable("message", message);
       
        return templateEngine.process("mail", context);
    }
	
}
