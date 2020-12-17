package jp.co.sample.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import jp.co.sample.dto.SampleProcDto;
import jp.co.sample.entity.Sample;

@Mapper
public interface SampleRepository {

    @Select("SELECT CODE, NAME FROM SAMPLE")
    List<Sample> findAll();

    @Select(value = "{CALL sample_procedure(" + "#{code, mode=IN}," + "#{name, mode=IN}," + "#{joined, mode=OUT, jdbcType=VARCHAR}" + ")}")
    @Options(statementType = StatementType.CALLABLE)
    void join(SampleProcDto sampleProcDto);
}
