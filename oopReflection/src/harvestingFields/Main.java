package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();

		Field[] fields = RichSoilLand.class.getDeclaredFields();

		while(!input.equals("HARVEST")){
				switch(input){
					case "private":
						Arrays.stream(fields).filter(field -> {
							return Modifier.isPrivate(field.getModifiers());
								}).forEach(field -> System.out.printf("private %s %s%n",
								field.getType().getSimpleName(),field.getName()));
						break;
					case "protected":
						Arrays.stream(fields).filter(field -> {
							return Modifier.isProtected(field.getModifiers());
						}).forEach(field -> System.out.printf("protected %s %s%n",
								field.getType().getSimpleName(),field.getName()));
						break;
					case "public":
						Arrays.stream(fields).filter(field -> {
							return Modifier.isPublic(field.getModifiers());
						}).forEach(field -> System.out.printf("public %s %s%n",
								field.getType().getSimpleName(),field.getName()));
						break;
					default:
						Arrays.stream(fields).forEach
								(field -> System.out.printf("%s %s %s%n",
										Modifier.toString(field.getModifiers())
										, field.getType().getSimpleName()
										,field.getName()));
						break;
				}

			input = scanner.nextLine();
		}
	}
}
