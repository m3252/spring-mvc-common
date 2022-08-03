package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ConversionServiceTest {

    @Test
    void conversionService() {
        //arrange
        DefaultConversionService conversionService = new DefaultConversionService(); // 추상객체
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        //act
        Integer integer = conversionService.convert("10", Integer.class);
        String string = conversionService.convert(10, String.class);
        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        String ipStr = conversionService.convert(new IpPort("127.0.0.1", 8080), String.class);

        //assert
        assertThat(integer).isEqualTo(10);
        assertThat(string).isEqualTo("10");
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));
        assertThat(ipStr).isEqualTo("127.0.0.1:8080");

    }

}
