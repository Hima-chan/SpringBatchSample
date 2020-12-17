package jp.co.sample.tasklet;

import java.util.List;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jp.co.sample.dto.SampleProcDto;
import jp.co.sample.entity.Sample;
import jp.co.sample.repository.SampleRepository;

@Component
public class SampleTasklet implements Tasklet {

    @Autowired
    SampleRepository sampleRepository;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {

        List<Sample> sampleList = sampleRepository.findAll();
        System.out.println("件数: " + sampleList.size());

        for (Sample sample : sampleList) {
            SampleProcDto sampleProcDto = new SampleProcDto();
            BeanUtils.copyProperties(sample, sampleProcDto);

            sampleRepository.join(sampleProcDto);

            System.out.println("結合結果: " + sampleProcDto.getJoined());
        }

        return RepeatStatus.FINISHED;
    }
}
