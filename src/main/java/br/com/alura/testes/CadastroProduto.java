package br.com.alura.testes;

import br.com.alura.dao.CategoriaDao;
import br.com.alura.dao.ProdutoDao;
import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Produto;
import br.com.alura.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroProduto {

    public static void main(String[] args) {

        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiaomi Redmi", "Prefiro a Samsung", new BigDecimal("800"), celulares);

        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();

        em.persist(celulares);
        celulares.setNome("XPTO");

        em.flush();
        em.clear();

        celulares = em.merge(celulares);
        celulares.setNome("1234");
        em.flush();
        em.clear();
        em.remove(celulares);
        em.flush();;
    }
}
