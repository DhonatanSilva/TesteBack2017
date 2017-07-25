package dao;

import java.awt.image.AreaAveragingScaleFilter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.hibernate.dialect.function.StandardAnsiSqlAggregationFunctions.AvgFunction;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.AVG;
import org.w3c.dom.css.CSSUnknownRule;

import com.mysql.jdbc.PreparedStatement;

import conexao.EntityManagerUtil;
import model.Customer;
import util.UtilErros;
import util.UtilMessagens;

public class DaoCustomer {

	private EntityManager em;

	public DaoCustomer() {
		em = EntityManagerUtil.getEntityManager();
	}

	public boolean gravar(Customer obj) {
		try {
			em.getTransaction().begin();
			if (obj.getId_customer() == null) {
				em.persist(obj);
			} else {
				em.merge(obj);
			}
			em.getTransaction().commit();
			UtilMessagens.mensagemInformacao("Objeto persistido com sucesso!");
			return true;
		} catch (Exception e) {
			if (em.getTransaction().isActive() == false) {
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
			UtilMessagens.mensagemErro("Erro ao persistir objeto: " + UtilErros.getMessagemErro(e));
			return false;
		}
	}

	public List<Customer> listarTodos() {
		return em.createQuery("from Customer order by id").getResultList();
	}

	public ArrayList<Customer> listarTodos2() {
		ArrayList<Customer> l = new ArrayList<>();
		return l = (ArrayList<Customer>) em
				.createQuery("from Customer where id between 1500 and 2700 and vl_total > 560 ").getResultList();

	}

	public Double calculoMedia() {
		ArrayList<Customer> lista = listarTodos2();
		Double media = 0.0;
		
		for (int i = 0; i < lista.size(); i++) {
		media = media + lista.get(i).getVl_total();

		}
		
		return media;
	}

}
