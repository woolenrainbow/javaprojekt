package our_GUI;
import java.math.BigDecimal;
import filereading.*;

public interface Our_GUI {
	public void GUI_init();
	//tworzenie interfejsu, przed stworzeniem tego nie należy ruszać poniższych
	public boolean load_table();
	//załadowanie tabeli zwróconej przez metode z paczki File_reading do pól tabeli w gui
	public boolean find_value();
	//zaznaczenie w tabeli w gui pól spełniających warunek przesłany np. przez flagę (założenie wstępne, można zmienić), należy dodać argumenty
	//do funkcji w interfejsie gdy zdecyduje się jak się ją zrobi
	public char[] display_range();
	//metoda która po zaznaczeniu przez użytkownika pól w tabeli wyświetli zakres wartości w przygotowanym na to polu interfejsu
	//char[] ma być zrzutowanym bigdecimalem
	public boolean color_field();
	//ma kolorować pola wybrane przez użytkownika, prawdopodobnie trzeba będzie po prostu podać na argument pole tabeli i zmienić mu bgcolor
	public boolean display_info();
	//wyświetlenie dymka z informacjami po najechaniu na przycisk, można to chyba zrobić za pomocą button.setTooltip, trzeba jeszcze dorobić tu
	//możliwość kopiowania do jakiegoś globalnego buforu informacji z dymku
	public BigDecimal[][] acces_copied_data();
	//metoda która będzie dostawać się do wcześniej skopiowanych danych, wstępnie zwraca BigDecimal, ale nie wim czy nie powinna po protu ładować
	//do buforu systemu także po ctrl + v wkleimy co mamy, choć nie jestem pewien czy trzeba, można też zamiast tego przerobić to na metode
	//powodującą wyświetlenie nowego okna z tymi danymi
	
	//bool jest do testów więc trzeba zwracać prawde lub jakimś wyjątkiemm czy czymś fałsz, jeżeli ktoś przewidzi że potrzebuje więcej niż
	//true false i null do obsługi wyjść i możliwych błędów to musi to zgłosić jeżeli to co robi jest używane przez coś innego
}
