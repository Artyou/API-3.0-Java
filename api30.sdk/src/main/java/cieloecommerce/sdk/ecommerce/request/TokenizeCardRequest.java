package cieloecommerce.sdk.ecommerce.request;

import cieloecommerce.sdk.Environment;
import cieloecommerce.sdk.Merchant;
import cieloecommerce.sdk.ecommerce.CreditCard;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import java.io.IOException;

/**
 * Tokenize a credit card
 */
public class TokenizeCardRequest extends AbstractRequest<CreditCard, CreditCard> {
	public TokenizeCardRequest(Merchant merchant, Environment environment) {
		super(merchant, environment);
	}

	@Override
	public CreditCard execute(CreditCard param) throws IOException, CieloRequestException {
		String url = environment.getApiUrl() + "1/card/";
		HttpPost request = new HttpPost(url);

		request.setEntity(new StringEntity(new GsonBuilder().create().toJson(param), ContentType.APPLICATION_JSON));

		HttpResponse response = sendRequest(request);

		return readResponse(response, CreditCard.class);
	}
}
