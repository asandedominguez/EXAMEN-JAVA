import java.sql.*;

public class CentroTraballoDAO {
    private static final String URL = "jdbc:postgresql://tuNumeroIp:5432/tu_Base_datos";
    private static final String USER = "tuUsuarioPostgres";
    private static final String PASSWORD = "tuUsuarioPostgres";

    private static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void crearTaboa() {
        String sql = """
                CREATE TABLE IF NOT EXISTS centro_traballo (
                    cif         VARCHAR(9)   PRIMARY KEY,
                    nome        VARCHAR(100) NOT NULL,
                    direccion   VARCHAR(200) NOT NULL,
                    localidade  VARCHAR(100) NOT NULL,
                    provincia   VARCHAR(100) NOT NULL
                )
                """;
        try (Connection con = conectar(); Statement st = con.createStatement()) {
            st.execute(sql);
            System.out.println("Táboa 'centro_traballo' creada ou xa existente.");
        } catch (SQLException e) {
            System.err.println("Erro ao crear a táboa: " + e.getMessage());
        }
    }

    // Inserimos un obxecto do modelo pasándolle tamén o CIF
    public static void inserirCentro(String cif, CentroTraballo centro) {
        String sql = "INSERT INTO centro_traballo (cif, nome, direccion, localidade, provincia) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cif);
            ps.setString(2, centro.getNome());
            ps.setString(3, centro.getDireccion());
            ps.setString(4, centro.getLocalidade());
            ps.setString(5, centro.getProvincia());

            ps.executeUpdate();
            System.out.println("Centro inserido correctamente: " + centro.getNome());
        } catch (SQLException e) {
            System.err.println("Erro ao inserir o centro: " + e.getMessage());
        }
    }
}