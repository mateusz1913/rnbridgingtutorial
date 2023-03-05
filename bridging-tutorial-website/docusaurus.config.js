// @ts-check
// Note: type annotations allow type checking and IDEs autocompletion

const darkCodeTheme = require('prism-react-renderer/themes/dracula');
const lightCodeTheme = require('prism-react-renderer/themes/github');

/** @type {import('@docusaurus/types').Config} */
const config = {
  title: 'Bridging Tutorial',
  tagline: 'Learn how to use any platform API in React Native app',
  favicon: 'img/favicon.ico',
  url: 'https://mateusz1913.github.io',
  baseUrl: '/rnbridgingtutorial/',
  organizationName: 'mateusz1913',
  projectName: 'rnbridgingtutorial',
  onBrokenLinks: 'throw',
  onBrokenMarkdownLinks: 'warn',
  // Even if you don't use internalization, you can use this field to set useful
  // metadata like html lang. For example, if your site is Chinese, you may want
  // to replace "en" with "zh-Hans".
  i18n: {
    defaultLocale: 'en',
    locales: [ 'en' ],
  },
  presets: [
    [
      'classic',
      /** @type {import('@docusaurus/preset-classic').Options} */
      {
        docs: {
          sidebarPath: require.resolve('./sidebars.js'),
          editUrl:
            'https://github.com/mateusz1913/rnbridgingtutorial/tree/main/docs',
        },
        theme: {
          customCss: require.resolve('./src/css/custom.css'),
        },
      },
    ],
  ],
  themeConfig:
    /** @type {import('@docusaurus/preset-classic').ThemeConfig} */
    {
      navbar: {
        title: 'Bridging Tutorial',
        logo: {
          alt: 'Bridging Tutorial logo',
          src: 'img/icon.svg',
        },
        items: [
          {
            type: 'doc',
            docId: 'getting-started',
            position: 'left',
            label: 'Getting Started',
          },
          {
            type: 'doc',
            docId: 'module-reference/module-intro',
            position: 'left',
            label: 'Module Reference',
          },
          {
            type: 'doc',
            docId: 'view-reference/view-intro',
            position: 'left',
            label: 'View Reference',
          },
          {
            href: 'https://github.com/mateusz1913/rnbridgingtutorial',
            label: 'GitHub',
            position: 'right',
          },
        ],
      },
      footer: {
        style: 'dark',
        links: [
          {
            title: 'Docs',
            items: [
              {
                label: 'Getting Started',
                to: '/docs/getting-started',
              },
            ],
          },
          {
            title: 'More',
            items: [
              {
                label: 'GitHub',
                href: 'https://github.com/mateusz1913/rnbridgingtutorial',
              },
            ],
          },
        ],
        copyright: `Copyright © ${new Date().getFullYear()} Mateusz Mędrek. Built with Docusaurus.`,
      },
      prism: {
        theme: lightCodeTheme,
        darkTheme: darkCodeTheme,
        additionalLanguages: [ 'java', 'kotlin', 'swift', 'ruby', 'groovy' ],
      },
    },
};

module.exports = config;
