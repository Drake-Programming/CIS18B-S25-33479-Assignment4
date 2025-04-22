import java.util.ArrayList;
import java.util.List;

public class LibrarySeed {
    public static List<Book> createSampleBooks() {
        List<Book> books = new ArrayList<>();

        // ===== Fantasy =====
        books.add(new Book("The Dragon's Oath",      "Ava Kingston",          "Fantasy"));
        books.add(new Book("Blade of Eldoria",       "Marcellus Gray",        "Fantasy"));
        books.add(new Book("Shadows of Elenor",      "Kiara Sloane",          "Fantasy"));
        books.add(new Book("The Moonlit Citadel",    "Rowan Thorn",           "Fantasy"));
        books.add(new Book("Crown of Embers",        "Helena Wren",           "Fantasy"));

        // ===== Science Fiction =====
        books.add(new Book("Nova Protocol",          "Elijah Pierce",         "Science Fiction"));
        books.add(new Book("Orbitfall",              "Sasha Vance",           "Science Fiction"));
        books.add(new Book("Echoes of Andromeda",    "Drake Hollis",          "Science Fiction"));
        books.add(new Book("Quantum Horizon",        "Lina Mercado",          "Science Fiction"));
        books.add(new Book("The Last Neural Node",   "Trevor Quint",          "Science Fiction"));

        // ===== Mystery =====
        books.add(new Book("The Clockmaker's Secret","Beatrice Lowell",       "Mystery"));
        books.add(new Book("Murder on Maple Row",    "Graham Ellis",          "Mystery"));
        books.add(new Book("Vanishing at Vesper Lake","Nadia Brooks",         "Mystery"));
        books.add(new Book("Silent Witness",         "Victor Hale",           "Mystery"));
        books.add(new Book("Cipher in Scarlet",      "Iris Chen",             "Mystery"));

        // ===== Horror =====
        books.add(new Book("Whispers in the Walls",  "Callum Price",          "Horror"));
        books.add(new Book("Midnight Harvest",       "Ophelia Knox",          "Horror"));
        books.add(new Book("The Hollowing",          "Silas Crane",           "Horror"));
        books.add(new Book("Gravebound",             "Mara Doyle",            "Horror"));
        books.add(new Book("Beneath Black Pines",    "Jasper Rook",           "Horror"));

        // ===== Non‑Fiction =====
        books.add(new Book("Decoding the Cosmos",    "Dr. Aria Patel",        "Fiction"));
        books.add(new Book("Machines That Learn",    "Colin Vargas",          "Fiction"));
        books.add(new Book("History of Forgotten Empires",
                "Selena Duarte",  "Fiction"));
        books.add(new Book("The Art of Resilience",  "Milo Shepherd",        "Fiction"));
        books.add(new Book("Mindful Engineering",    "Yara Fulton",          "Fiction"));

        return books;
    }
}
