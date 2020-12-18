# SpringBatchSample

## eclipseへのインポート

ディレクトリ： SpringBatchSample直下にて、下記コマンドを実施
>./gradlew eclipse

eclipseで下記を選択
>ファイル -> インポート -> 既存プロジェクトをワークスペースへ

ルートディレクトリに当該プロジェクトのディレクトリを設定

## Jarファイルの作成
ディレクトリ： SpringBatchSample直下にて、下記コマンドを実施
>./gradlew bootJar

下記ディレクトリにJarファイルが作成される
> SpringBatchSample\build\libs

## Jarファイルの実行

下記のコマンドを実行
>java -Dspring.profiles.active=dev -Dspring.batch.job.names=taskletSampleJob -jar SpringBatchSample-0.0.1-SNAPSHOT.jar

※1 -Dspring.profiles.activeはローカル実行だと不要、どの環境用の設定ファイルで実行するか指定
※2 -Dspring.batch.job.namesはジョブ名を指定（ジョブクラス内で指定している）、未指定の場合はジョブが全実行される