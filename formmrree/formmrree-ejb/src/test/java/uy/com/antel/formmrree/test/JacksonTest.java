package uy.com.antel.formmrree.test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import uy.com.antel.formmrree.model.Member;

public class JacksonTest {

	@Test
	public void test() throws JsonParseException, JsonMappingException, MalformedURLException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Member mem = mapper.readValue(new URL("https://localhost/formmrree/rest/members/1"), Member.class);
//		Member mem = mapper.readValue(new URL("https://190.0.159.93:8443/formmrree/rest/nacionalidades/1"), Member.class);
		System.out.println(mem.toString());
		Assert.assertNotNull(mem);
	}

}
