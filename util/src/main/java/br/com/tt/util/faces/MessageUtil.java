package br.com.tt.util.faces;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class MessageUtil {
	public static void info(String summary, String detail) {
message(FacesMessage.SEVERITY_INFO, summary, detail);
	}
	public static void warn(String summary, String detail) {
		message(FacesMessage.SEVERITY_WARN, summary, detail);
	}

public static void error(String summary, String detail) {
	message(FacesMessage.SEVERITY_ERROR, summary, detail);
}
public static void fatal(String summary, String detail) {
	message(FacesMessage.SEVERITY_FATAL, summary, detail);
}
	
	private static void message(
			Severity severityWarn, 
			String summary, 
			String detail) {
		FacesContext currentInstance = FacesContext
				.getCurrentInstance();
		FacesMessage message = new FacesMessage
				(severityWarn,
						summary, detail);
		currentInstance.addMessage(null, message);
	}
}
