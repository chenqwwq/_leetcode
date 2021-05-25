package top.chenqwwq.basis;

/**
 * @author chen
 * @date 2021-05-25
 **/
public class Main {

	interface Function {
		int calculation(int param1, int param2);
	}

	enum OperateEnum {
		ADD('+', Integer::sum),
		SUB('-', (param1, param2) -> param1 - param2),
		MUL('*', (param1, param2) -> param1 * param2),
		DEV('/', (param1, param2) -> {
			if (param2 == 0) {
				throw new IllegalArgumentException();
			}
			return param1 / param2;
		});
		char operate;
		Function function;

		OperateEnum(char operate, Function function) {
			this.operate = operate;
			this.function = function;
		}

		public static Function getFunction(char c) {
			for (OperateEnum operate : OperateEnum.values()) {
				if (operate.operate == c) {
					return operate.function;
				}
			}
			throw new IllegalArgumentException();
		}

		public static int handle(char operate, int param1, int param2) {
			return getFunction(operate).calculation(param1, param2);
		}
	}

	interface Token {
		default boolean isNumber() {
			return false;
		}

		int getResult();
	}

	static class Number implements Token {
		private int num;

		@Override
		public boolean isNumber() {
			return true;
		}

		@Override
		public int getResult() {
			return num;
		}

		public Number(int num) {
			this.num = num;
		}
	}

	static class Operate implements Token {
		public static final Operate NULL = new Operate();
		private char operate;
		private Token left;
		private Token right;

		@Override
		public int getResult() {
			return OperateEnum.handle(operate, left.getResult(), right.getResult());
		}
	}

	public Token parsing(String express) {
		if (express == null || express.isEmpty()) {
			return Operate.NULL;
		}
		boolean isExpress = false;
		for (int i = 0; i < express.length(); i++) {
			final char c = express.charAt(i);
			if (c == '+' || c == '-') {

			}
		}
		return new Number(Integer.parseInt(express));
	}
}
