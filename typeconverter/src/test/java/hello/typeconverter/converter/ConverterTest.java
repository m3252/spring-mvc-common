package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConverterTest {

    @Test
    void stringToInteger() {
        StringToIntegerConverter stringToIntegerConverter = new StringToIntegerConverter();
        Integer result = stringToIntegerConverter.convert("10");
        assertThat(result).isEqualTo(10);
    }

    @Test
    void integerToString() {
        IntegerToStringConverter integerToStringConverter = new IntegerToStringConverter();
        String result = integerToStringConverter.convert(10);
        assertThat(result).isEqualTo("10");
    }

    @Test
    void stringToIpPort() {
        StringToIpPortConverter stringToIpPortConverter = new StringToIpPortConverter();
        IpPort convert = stringToIpPortConverter.convert("127.0.0.1:78");
        assertThat(convert.getIp()).isEqualTo("127.0.0.1");
        assertThat(convert.getPort()).isEqualTo(78);
    }

    @Test
    void ipPortToString() {
        IpPortToStringConverter ipPortToStringConverter = new IpPortToStringConverter();
        IpPort ipPort = new IpPort("127.0.0.1", 79);
        String convert = ipPortToStringConverter.convert(ipPort);
        assertThat(convert).isEqualTo("127.0.0.1:79");
    }
}
