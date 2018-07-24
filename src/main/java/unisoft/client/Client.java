package unisoft.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.namespace.QName;

import unisoft.ws.FNSNDSCAWS2;
import unisoft.ws.FNSNDSCAWS2Port;
import unisoft.ws.fnsndscaws2.request.NdsRequest2;
import unisoft.ws.fnsndscaws2.response.NdsResponse2;

public class Client {
	
	public void getResult(String[] args) throws MalformedURLException {
		if (args.length == 0 || args.length > 2) {
			System.out.println("Использование: файл <ИНН> [КПП] \nДатой сделки считается текущая дата.");
		}else {
		NdsRequest2 npIn = new NdsRequest2();
		NdsRequest2.NP np = new NdsRequest2.NP();
		np.setINN(args[0]);
		if (args.length == 2) {
			np.setKPP(args[1]);
		}
		Date now = new Date();
		SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
		np.setDT(formatDate.format(now));
		npIn.getNP().add(np);
		NdsResponse2 ndsResponse2 = new NdsResponse2();
		FNSNDSCAWS2 fnsndscaws2 = new FNSNDSCAWS2(new URL("http://npchk.nalog.ru/FNSNDSCAWS_2?wsdl"), new QName("http://ws.unisoft", "FNSNDSCAWS2"));
		FNSNDSCAWS2Port fnsndscaws2Port = fnsndscaws2.getFNSNDSCAWS2Port();
		ndsResponse2 = fnsndscaws2Port.ndsRequest2(npIn);
		for (NdsResponse2.NP response2NP : ndsResponse2.getNP()) {
			StateDescription statedescription = new StateDescription();
			try {
				statedescription.getStateDescription(Integer.parseInt(response2NP.getState()));
			}catch (NumberFormatException e) {
				System.out.println("Ошибка в работе сервиса. Обратитесь в техническую поддержку.");
			}
        }
		}
	}
	public static void main(String[] args) {
		try {
			new Client().getResult(args);
		}catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
