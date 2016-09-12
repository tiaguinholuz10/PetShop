package br.com.tt.pet.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.com.tt.util.CnpjUtil;

@FacesValidator
public class CnpjValidator implements Validator {

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		String cnpj = (String) value;
		if (!CnpjUtil.validar((String) cnpj)) {

			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("CNPJ Inválido");
			message.setDetail("CNPJ Inválido");
			throw new ValidatorException(message);

		}

	}

}
