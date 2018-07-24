package unisoft.client;

public class StateDescription {

	private String[] stateDesc = new String[13];
	StateDescription() {
		stateDesc[0] = "Налогоплательщик зарегистрирован в ЕГРН и имел статус действующего в указанную дату";
		stateDesc[1] = "Налогоплательщик зарегистрирован в ЕГРН, но не имел статус действующего в указанную дату";
		stateDesc[2] = "Налогоплательщик зарегистрирован в ЕГРН";
		stateDesc[3] = "Налогоплательщик с указанным ИНН зарегистрирован в ЕГРН, КПП не соответствует ИНН или не указан. Примечание: если указывался КПП, то он соответствует формату и указание такого КПП не будет являться ошибкой при представлении декларации и камеральной проверке";
		stateDesc[4] = "Налогоплательщик с указанным ИНН не зарегистрирован в ЕГРН";
		stateDesc[5] = "Некорректный ИНН";
		stateDesc[6] = "Недопустимое количество символов ИНН";
		stateDesc[7] = "Недопустимое количество символов КПП";
		stateDesc[8] = "Недопустимые символы в ИНН";
		stateDesc[9] = "Недопустимые символы в КПП";
		stateDesc[10] = "КПП не должен использоваться при проверке ИП";
		stateDesc[11] = "некорректный формат даты";
		stateDesc[12] = "некорректная дата (ранее 01.01.1991 или позднее текущей даты)";
	}
	
	public void getStateDescription(int state) {
		if(state < 0 || state > 12) {
			System.out.println("Ошибка в работе сервиса. Обратитесь в техническую поддержку.");
		}else {
			System.out.println(stateDesc[state]);
		}
	}
}