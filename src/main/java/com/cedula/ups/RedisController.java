import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestController
@RequestMapping("/redis)
public class RedisController{

	@Autowired
	private RedisService redisService;

	@PostMapping("/set")
	public String setKeyValue(@RequestParam String key, @RequestParam String value){
		redisService.setKeyValue(key, value);
		return "Valor guardado";
	}

	@GetMapping("/get")
	public String getValue(@RequestParam String key){
		return redisService.getValue(key);
	}
}
