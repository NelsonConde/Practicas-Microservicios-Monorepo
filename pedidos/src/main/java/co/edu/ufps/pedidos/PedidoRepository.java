package co.edu.ufps.pedidos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
        List<Pedido> findByNombreContainingIgnoreCase(String nombre);
}