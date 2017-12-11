import java.util.ArrayList;
import java.util.Scanner;

public class Nyoh {

	ArrayList<PhoneData> datas = new ArrayList<>();
	Scanner in = new Scanner(System.in);

	public Nyoh() {
		// TODO Auto-generated constructor stub
		datas.add(new PhoneData("Uhhh", "0897712616", "Jl.UHHHHHHH"));
		datas.add(new PhoneData("AAhhh", "0897712233", "Jl.aHHHHHHH"));
		datas.add(new PhoneData("EEhhh", "0897712111", "Jl.iHHHHHHH"));
		datas.add(new PhoneData("IIhhh", "08977123333", "Jl.eHHHHHHH"));
	}

	public void showKontak() {
		String format = "| %-2d | %-20s | %-15s | %-36s | %n";
		System.out.format("+----+----------------------+-----------------+--------------------------------------+%n");
		System.out.format("| No | Nama                 + Nomor           + Keterangan                           |%n");
		System.out.format("+----+----------------------+-----------------+--------------------------------------+%n");
		for (int i = 0; i < datas.size(); i++) {
			PhoneData data = datas.get(i);
			System.out.format(format, (i + 1), data.getName(), data.getPhone(), data.getAddress());
		}
		System.out.format("+----+----------------------+-----------------+--------------------------------------+%n");
	}

	public void showAdd() {
		PhoneData data = new PhoneData("", "", "");
		System.out.println("\n\nTambah Kontak");
		System.out.println("---------------------------------------");
		System.out.print("Nama : ");
		data.setName(in.nextLine());
		System.out.print("Nomor: ");
		data.setPhone(in.nextLine());
		System.out.print("Alamat : ");
		data.setAddress(in.nextLine());

		datas.add(data);

		System.out.println("\nTersimpan.. ");
	}

	public void showEdit() {
		showKontak();
		System.out.print("Pilih no : ");
		int no = in.nextInt();
		
		PhoneData data = datas.get(no - 1);
		System.out.println("---------------------------------------");
		System.out.print("Nama Baru : ");
		data.setName(in.next());
		System.out.print("Nomor Baru : ");
		data.setPhone(in.next());
		System.out.print("Alamat Baru : ");
		data.setAddress(in.next());
		System.out.println("\nTersimpan.. ");
	}
	
	public void showDelete() {
		showKontak();
		System.out.print("Pilih no : ");
		int no = in.nextInt();
		datas.remove(no - 1);
		System.out.println("\nData di hapus.. ");
	}
	
	public void showCari() {
		System.out.println("\nBerdasarkan : ");
		System.out.println("----------------------");
		System.out.println("1. Nama");
		System.out.println("2. Nomor");
		System.out.println("----------------------");
		System.out.print("Pilih : ");
		switch (in.nextInt()) {
		case 1:
			System.out.print("\nNama : ");
			showByNama(in.next());
			break;
		case 2:
			System.out.print("\nNomor : ");
			showByNumber(in.next());
			break;
		default:
			break;
		}
	}
	
	private void showByNama(String nama) {
		String format = "| %-2d | %-20s | %-15s | %-36s | %n";
		System.out.format("+----+----------------------+-----------------+--------------------------------------+%n");
		System.out.format("| No | Nama                 + Nomor           + Keterangan                           |%n");
		System.out.format("+----+----------------------+-----------------+--------------------------------------+%n");
		for (int i = 0; i < datas.size(); i++) {
			PhoneData data = datas.get(i);
			
			if (!data.getName().toLowerCase().contains(nama.toLowerCase())) {
				continue;
			}
			
			System.out.format(format, (i + 1), data.getName(), data.getPhone(), data.getAddress());
		}
		System.out.format("+----+----------------------+-----------------+--------------------------------------+%n");
	}
	
	private void showByNumber(String number) {
		String format = "| %-2d | %-20s | %-15s | %-36s | %n";
		System.out.format("+----+----------------------+-----------------+--------------------------------------+%n");
		System.out.format("| No | Nama                 + Nomor           + Keterangan                           |%n");
		System.out.format("+----+----------------------+-----------------+--------------------------------------+%n");
		for (int i = 0; i < datas.size(); i++) {
			PhoneData data = datas.get(i);
			
			if (!data.getPhone().contains(number)) {
				continue;
			}
			
			System.out.format(format, (i + 1), data.getName(), data.getPhone(), data.getAddress());
		}
		System.out.format("+----+----------------------+-----------------+--------------------------------------+%n");
	}
	
	public static void main(String... args) {

		Nyoh nyoh = new Nyoh();
		Scanner in = new Scanner(System.in);

		while (true) {
			System.out.println("\nMenu : ");
			System.out.println("----------------------");
			System.out.println("1. Daftar Kontak");
			System.out.println("2. Tambah Kontak");
			System.out.println("3. Ubah Kontak");
			System.out.println("4. Hapus Kontak");
			System.out.println("5. Cari Kontak");
			System.out.println("----------------------");

			System.out.print("Input > ");

			int menu = in.nextInt();

			switch (menu) {
			case 1:
				nyoh.showKontak();
				break;
			case 2:
				nyoh.showAdd();
				break;
			case 3:
				nyoh.showEdit();
				break;
			case 4:
				nyoh.showDelete();
				break;
			case 5:
				nyoh.showCari();
				break;
			default:
				break;
			}
		}
	}

	private class PhoneData {
		private String name;
		private String phone;
		private String address;

		public PhoneData(String name, String phone, String address) {
			super();
			this.name = name;
			this.phone = phone;
			this.address = address;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

	}
}
