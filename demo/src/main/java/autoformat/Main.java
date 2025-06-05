package autoformat;

import autoformat.entity.User;

import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AutoFormatPU");
        EntityManager em = emf.createEntityManager();

        User p = new User();
        p.setCpf("123.456.789-00"); // Deve ser desformatado no banco
        //p.setPhone("(11) 98765-4321"); // Deve ser desformatado no banco
        //p.setPrice("1000.00"); // Deve ser desformatado no banco
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.clear(); // Limpa o contexto de persistência

        System.out.println(">>> Buscando usuário...");
        User encontrado = em.find(User.class, p.getId());
        System.out.println(">>> Usuário encontrado!");
        System.out.println("CPF formatado: " + encontrado.getCpf());
        //System.out.println("Telefone formatado: " + encontrado.getPhone());
        //System.out.println("Preço formatado: " + encontrado.getPrice());
        em.close();
        emf.close();
    }
}
