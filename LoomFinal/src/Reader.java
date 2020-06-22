	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.io.PrintWriter;

	public class Reader {

		private int amountOfPeople;
		private int[] pattern;

		public Reader() {
			try {
				read();
			} catch (IOException e) {
				throw new Error("No se pudo leer el archivo");
			}
		}
		
		private void read() throws IOException {
			BufferedReader br = new BufferedReader(new FileReader("Aventureros.in.txt"));
			
			String line = br.readLine();
			line.trim();
			amountOfPeople = Integer.parseInt(line);
			pattern = new int[amountOfPeople-1];


			line = br.readLine();
			String[] split = line.split(" ");
			for(int i=0;i<pattern.length;i++) {
				pattern[i] = Integer.parseInt(split[i]);
			}
			
			br.close();
		}

		public int getAmountOfPeople() {
			return amountOfPeople;
		}

		public int[] getPattern() {
			return pattern;
		}

		public void write(int[] winners, int loser) {
			PrintWriter pw;
			try {
				pw = new PrintWriter(new File("Aventureros.out.txt"));

				StringBuilder write = new StringBuilder();
				
				for(int i=0; i<winners.length; i++) {
					write.append(winners[i]+ " ");
				}
				write.append('\n');
				write.append(loser);
				pw.write(write.toString());
				pw.close();

			} catch (FileNotFoundException e) {
				throw new Error("No se pudo escribir en el archivo");
			}


		}
	}
