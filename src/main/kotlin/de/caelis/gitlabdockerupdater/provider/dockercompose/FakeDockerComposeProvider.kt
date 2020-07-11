package de.caelis.gitlabdockerupdater.provider.dockercompose

class FakeDockerComposeProvider : IDockerComposeProvider {
    override fun getContent(): String {
        return "version: '3'\n" +
                "\n" +
                "services:\n" +
                "    gitlab:\n" +
                "        image: gitlab/gitlab-ce:12.9.0-ce.0\n" +
                "        restart: always\n" +
                "        container_name: gitlab\n" +
                "        environment:\n" +
                "            GITLAB_OMNIBUS_CONFIG: |\n" +
                "                external_url 'https://gitlab.maax.gr'\n" +
                "                nginx['listen_port'] = 80\n" +
                "                nginx['listen_https'] = false\n" +
                "                nginx['proxy_set_headers'] = {\n" +
                "                    \"X-Forwarded-Proto\" => \"https\",\n" +
                "                    \"X-Forwarded-Ssl\" => \"on\"\n" +
                "                }\n" +
                "            VIRTUAL_HOST: gitlab.maax.gr\n" +
                "            LETSENCRYPT_HOST: gitlab.maax.gr\n" +
                "            LETSENCRYPT_EMAIL: admin@maax.gr\n" +
                "        volumes:\n" +
                "            - ./config:/etc/gitlab\n" +
                "            - ./logs:/var/log/gitlab\n" +
                "            - ./data:/var/opt/gitlab\n" +
                "#            - /home/git/.ssh/authorized_keys_proxy:/gitlab-data/ssh/authorized_keys\n" +
                "        ports:\n" +
                "            - \"2222:22\"\n" +
                "\n" +
                "networks:\n" +
                "    default:\n" +
                "        external:\n" +
                "            name: compose-net\n"
    }

    override fun setContent(content: String) {
        println("Write: $content")
    }
}