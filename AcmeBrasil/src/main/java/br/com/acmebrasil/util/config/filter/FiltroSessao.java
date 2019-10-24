package br.com.acmebrasil.util.config.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Component;

/**
 * Servlet Filter implementation class FiltroSessao
 */
@Component
@WebFilter("/api/*")
public class FiltroSessao implements Filter {

	private List<String> urlsAbertas;

	/**
	 * Default constructor.
	 */
	public FiltroSessao() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Object sessao = ((HttpServletRequest) request).getSession().getAttribute("usuario");
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		if (sessao == null && !urlsAbertas.stream().anyMatch(s -> httpServletRequest.getRequestURI().contains(s)) && !httpServletRequest.getRequestURI().contentEquals("/")) {
			HttpServletResponse resposta = (HttpServletResponse) response;
			resposta.setStatus(Status.UNAUTHORIZED.getStatusCode());
		} else {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		urlsAbertas = new ArrayList<>();
		urlsAbertas.add("usuario/salva");
		urlsAbertas.add("usuario/autentica");
		urlsAbertas.add("usuario/testa");
		urlsAbertas.add("componentes");
	}

}
