package fact.service;

import com.tag.dto.ResponseDto;
import com.tag.dto.Result;
import org.springframework.stereotype.Service;

import java.net.InetAddress;

@Service
public class FactService {

    public ResponseDto calculateFactorial(final int number){
        final long result = getFact(number);
        return  ResponseDto.newInstance(r -> {
            r.setInput(number);
            r.setType("fact");
            r.setResponse(Result.newInstance(res -> {
                res.setResult(result);
                res.setCalculatedInstance(getHostName());
            }));
        });
    }

    private String getHostName(){
        try{
            return InetAddress.getLocalHost().getHostName();
        }catch(Exception e){
            return "UNKNOWN";
        }
    }

    private long getFact(int number){
        long fact = 1;
        for (int i = 2; i <= number; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
