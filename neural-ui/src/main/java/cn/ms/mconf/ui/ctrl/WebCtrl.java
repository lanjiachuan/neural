package cn.ms.mconf.ui.ctrl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ms.mconf.ui.service.LimiterService;
import cn.ms.neural.limiter.LimiterRule;

@Controller
@RequestMapping("web")
public class WebCtrl {

	@Resource
	private LimiterService limiterService;

	@RequestMapping(value = "index")
	public String index(HttpServletRequest request) {
		return "index";
	}

	/**
	 * 首页
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "main")
	public String main(HttpServletRequest request) {
		return "main";
	}

	/**
	 * 限流规则列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "limiterRules")
	public String limiterRules(String keywords, HttpServletRequest request) {
		if(keywords == null){
			keywords = "";
		}
		List<LimiterRule> limiterRule = limiterService.queryLimiterRules(keywords);
		request.setAttribute("limiterRules", limiterRule);
		return "limiter_rules";
	}

}
